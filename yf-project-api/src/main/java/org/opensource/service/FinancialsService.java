package org.opensource.service;

import org.opensource.model.response.financials.YahooFinancials;
import org.opensource.model.web.CrumbCookie;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class FinancialsService extends YahooService<YahooFinancials> implements IYahooEndpointServiceExecutable {

  @Override
  public YahooFinancials execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      CrumbCookie crumbCookie = getCrumbCookie(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(crumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooFinancials.class);
    } catch (IOException e) {
      return new YahooFinancials();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = "incomeStatementHistory,cashflowStatementHistory,balanceSheetHistory,incomeStatementHistoryQuarterly,cashflowStatementHistoryQuarterly,balanceSheetHistoryQuarterly";
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }

}
