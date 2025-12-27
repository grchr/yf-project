package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.exceptions.YahooSessionException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSession;
import org.opensource.model.web.YahooSessionFactory;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class ChartsService extends YahooServiceSync<YahooEventChart> implements IYahooEndpointServiceExecutable {

  public ChartsService() {
    super();
  }

  public ChartsService(YahooSession session) {
    super(session);
  }

  @Override
  public YahooEventChart execute(String ticker) throws YahooServiceException {

    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }
      String url = prepareUrl(ticker, session.crumb());
      Request request = YahooRequestFactory.createYahooRequest(url);

      try (Response response = session.client().newCall(request).execute()) {
        return getResult(response, YahooEventChart.class);
      }
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
    } catch (YahooSessionException e) {
      throw new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker);
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "dividends,split";
    return String.format(
            "https://query2.finance.yahoo.com/v8/finance/chart/%s?range=max&interval=1d&events=%s&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
