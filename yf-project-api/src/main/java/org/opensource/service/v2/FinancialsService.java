package org.opensource.service.v2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.financials.YahooFinancials;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class FinancialsService extends YahooServiceSync<YahooFinancials> implements IYahooEndpointServiceExecutable {

  public FinancialsService() {
    super();
  }

  public FinancialsService(OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  @Override
  public YahooFinancials execute(String ticker) throws YahooServiceException {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooFinancials.class);
      }
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "incomeStatementHistory,cashflowStatementHistory,balanceSheetHistory,incomeStatementHistoryQuarterly,cashflowStatementHistoryQuarterly,balanceSheetHistoryQuarterly";
    return String.format(
            "https://query2.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
