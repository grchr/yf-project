package org.opensource.service;

import org.opensource.model.response.IYahooResponse;

public interface IYahooEndpointServiceExecutable {

  IYahooResponse execute(String ticker);
}
