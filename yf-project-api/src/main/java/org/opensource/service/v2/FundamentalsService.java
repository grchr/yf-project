package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.exceptions.YahooSessionException;
import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSession;
import org.opensource.model.web.YahooSessionFactory;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.time.Instant;

public class FundamentalsService extends YahooServiceSync<YahooFundamentals> implements IYahooEndpointServiceExecutable {

  public FundamentalsService() {
    super();
  }

  public FundamentalsService(YahooSession session) {
    super(session);
  }

  @Override
  public YahooFundamentals execute(String ticker) throws YahooServiceException {

    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }
      String url = prepareUrl(ticker, session.crumb());
      Request request = YahooRequestFactory.createYahooRequest(url);

      try (Response response = session.client().newCall(request).execute()) {
        return getResult(response, YahooFundamentals.class);
      }
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
    } catch (YahooSessionException e) {
      throw new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker);
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "annualTotalRevenue,annualNetIncome,annualOperatingIncome";
    long period2 = Instant.now().getEpochSecond();
    return String.format(
            "https://query2.finance.yahoo.com/ws/fundamentals-timeseries/v1/finance/timeseries/%s?symbol=%s&type=%s&period1=0&period2=%s&crumb=%s",
            encode(ticker), encode(ticker), modules, period2, encode(crumb)
    );
  }
}
