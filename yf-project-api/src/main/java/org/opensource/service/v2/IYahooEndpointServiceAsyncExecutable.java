package org.opensource.service.v2;

import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.IYahooResponse;

import java.util.concurrent.CompletableFuture;

public interface IYahooEndpointServiceAsyncExecutable {

  CompletableFuture<? extends IYahooResponse> executeAsync(String ticker) throws YahooServiceException;

}
