package org.opensource.service.v2;

import okhttp3.CookieJar;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.exceptions.YahooSessionException;
import org.opensource.model.response.keystats.YahooKeyStatistics;
import org.opensource.model.web.YahooCookieJar;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSession;
import org.opensource.model.web.YahooSessionFactory;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class KeyStatisticsService extends YahooServiceSync<YahooKeyStatistics> implements IYahooEndpointServiceExecutable {

  public KeyStatisticsService() {
    super();
  }

  public KeyStatisticsService(YahooSession session) {
    super(session);
  }

  @Override
  public YahooKeyStatistics execute(String ticker) throws YahooServiceException {

    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }
      String url = prepareUrl(ticker, session.crumb());
      Request request = YahooRequestFactory.createYahooRequest(url);

      try (Response response = session.client().newCall(request).execute()) {
        return getResult(response, YahooKeyStatistics.class);
      }
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
    } catch (YahooSessionException e) {
      throw new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker);
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "summaryProfile%2CfinancialData%2CrecommendationTrend%2Cearnings%2CequityPerformance%2CsummaryDetail%2CdefaultKeyStatistics%2CcalendarEvents%2CesgScores%2Cprice%2CpageViews%2CfinancialsTemplate%2CearningsCallAudios%2CquoteUnadjustedPerformanceOverview%2CcorporateActions%2CearningsCallTranscripts%2CearningsGaap%2CearningsNonGaap%2CupgradeDowngradeHistory";
    return String.format(
            "https://query2.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
