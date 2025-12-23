package org.opensource.service;

import org.opensource.model.response.keystats.YahooKeyStatistics;
import org.opensource.model.web.CrumbCookie;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class KeyStatisticsService extends YahooService<YahooKeyStatistics> implements IYahooEndpointServiceExecutable {

  public YahooKeyStatistics execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      CrumbCookie crumbCookie = getCrumbCookie(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(crumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooKeyStatistics.class);
    } catch (IOException e) {
      return new YahooKeyStatistics();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = "summaryProfile%2CfinancialData%2CrecommendationTrend%2Cearnings%2CequityPerformance%2CsummaryDetail%2CdefaultKeyStatistics%2CcalendarEvents%2CesgScores%2Cprice%2CpageViews%2CfinancialsTemplate%2CearningsCallAudios%2CquoteUnadjustedPerformanceOverview%2CcorporateActions%2CearningsCallTranscripts%2CearningsGaap%2CearningsNonGaap%2CupgradeDowngradeHistory";
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
