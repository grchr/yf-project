package org.opensource.service;

import org.opensource.model.IYahooResponse;

public interface IYahooEndpointServiceExecutable {

  IYahooResponse execute(String ticker);
}
