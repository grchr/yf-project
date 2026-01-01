package org.opensource.service.v1;

import org.apache.commons.lang3.StringUtils;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.keystats.YahooKeyStatistics;
import org.opensource.model.response.predictions.YahooAnalystData;
import org.opensource.model.web.CrumbCookie;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.net.HttpURLConnection;

public class PredictionsService extends YahooService<YahooAnalystData> implements IYahooEndpointServiceExecutable {

  public PredictionsService() {
    super();
  }

  public PredictionsService(CrumbCookie lastUsedCrumbCookie) {
    super(lastUsedCrumbCookie);
  }

  public YahooAnalystData execute(String ticker) throws YahooServiceException {
    try {
      if (lastUsedCrumbCookie == null || StringUtils.isEmpty(lastUsedCrumbCookie.getCrumb()) || StringUtils.isEmpty(lastUsedCrumbCookie.getCookie())) {
        logger.debug("Fetching new crumb and cookie for ticker: {}", ticker);
        HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
        lastUsedCrumbCookie = getCrumbCookie(crumbConn);
      }
      String quoteSummaryUrl = prepareUrl(ticker, lastUsedCrumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(lastUsedCrumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooAnalystData.class);
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "recommendationTrend%2CfinancialData%2CearningsHistory%2CearningsTrend%2Cearnings%2CindustryTrend%2CindexTrend%2CsectorTrend";
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
