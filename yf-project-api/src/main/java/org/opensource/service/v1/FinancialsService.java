package org.opensource.service.v1;

import org.apache.commons.lang3.StringUtils;
import org.opensource.model.response.financials.YahooFinancials;
import org.opensource.model.web.CrumbCookie;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.net.HttpURLConnection;

public class FinancialsService extends YahooService<YahooFinancials> implements IYahooEndpointServiceExecutable {

  public FinancialsService() {
    super();
  }

  public FinancialsService(CrumbCookie lastUsedCrumbCookie) {
    super(lastUsedCrumbCookie);
  }

  @Override
  public YahooFinancials execute(String ticker) {
    try {
      if (lastUsedCrumbCookie == null || StringUtils.isEmpty(lastUsedCrumbCookie.getCrumb()) || StringUtils.isEmpty(lastUsedCrumbCookie.getCookie())) {
        HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
        lastUsedCrumbCookie = getCrumbCookie(crumbConn);
      }
      String quoteSummaryUrl = prepareUrl(ticker, lastUsedCrumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(lastUsedCrumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooFinancials.class);
    } catch (IOException e) {
      return new YahooFinancials();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "incomeStatementHistory,cashflowStatementHistory,balanceSheetHistory,incomeStatementHistoryQuarterly,cashflowStatementHistoryQuarterly,balanceSheetHistoryQuarterly";
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }

}
