package org.opensource.service.v1;

import org.opensource.model.response.IYahooResponse;

public interface IYahooEndpointServiceExecutable {

  IYahooResponse execute(String ticker);
}
