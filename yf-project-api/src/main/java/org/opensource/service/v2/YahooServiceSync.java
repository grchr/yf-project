package org.opensource.service.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.response.IYahooResponse;
import org.opensource.model.web.YahooSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class YahooServiceSync<T extends IYahooResponse> extends YahooService<T> {

  Logger logger = LoggerFactory.getLogger(YahooServiceSync.class);

  protected YahooServiceSync() {
    super();
  }

  protected YahooServiceSync(YahooSession session) {
    super(session);
  }

  protected T getResult(Response response, Class<T> clazz) throws IOException {
    if (!response.isSuccessful()) {
      logger.warn("Unsuccessful response: {}", response);
      throw new IOException("Unexpected response " + response);
    }
    ObjectMapper objectMapper = JsonMapper.get();
    try {
      return objectMapper.readValue(response.body().byteStream(), clazz);
    } catch (NullPointerException e) {
      logger.warn("Yahoo Data Response body is null");
      throw new IOException("Response body is null", e);
    }
  }
}
