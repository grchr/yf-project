package org.opensource.service;

import org.opensource.model.AbstractCompanyInformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public interface IWebExecutableService<T extends AbstractCompanyInformation> {

  T execute(String ticker);

  CompletableFuture<T> executeAsync(String ticker);

  CompletableFuture<T> executeAsync(String ticker, ExecutorService customExecutor);

}
