package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.model.response.keystats.YahooKeyStatistics;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class KeyStatisticsService extends YahooServiceSync<YahooKeyStatistics> implements IYahooEndpointServiceExecutable {

  @Override
  public YahooKeyStatistics execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      String crumb = getCrumb();
      System.out.println("Crumb: " + crumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, crumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooKeyStatistics.class);
      }
    } catch (IOException e) {
      return new YahooKeyStatistics();
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
