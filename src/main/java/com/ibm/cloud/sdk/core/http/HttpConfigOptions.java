package com.ibm.cloud.sdk.core.http;

import okhttp3.Authenticator;

import java.net.Proxy;

/**
 * Options class for configuring the HTTP client.
 */
public class HttpConfigOptions {
  private boolean disableSslVerification;
  private Proxy proxy;
  private Authenticator proxyAuthenticator;

  public boolean shouldDisableSslVerification() {
    return this.disableSslVerification;
  }

  public Proxy getProxy() {
    return this.proxy;
  }

  public Authenticator getProxyAuthenticator() {
    return this.proxyAuthenticator;
  }

  public static class Builder {
    private boolean disableSslVerification;
    private Proxy proxy;
    private Authenticator proxyAuthenticator;

    public HttpConfigOptions build() {
      return new HttpConfigOptions(this);
    }

    /**
     * Sets flag to disable any SSL certificate verification during HTTP requests. This should ONLY be used if truly
     * intended, as it's unsafe otherwise.
     *
     * @param disableSslVerification whether to disable SSL verification or not
     * @return the builder
     */
    public Builder disableSslVerification(boolean disableSslVerification) {
      this.disableSslVerification = disableSslVerification;
      return this;
    }

    /**
     * Sets HTTP proxy to be used by connections with the current client.
     *
     * @param proxy the desired {@link Proxy}
     * @return the builder
     */
    public Builder proxy(Proxy proxy) {
      this.proxy = proxy;
      return this;
    }

    /**
     * Sets HTTP proxy authentication to be used by connections with the current client.
     *
     * @param proxyAuthenticator the desired {@link Authenticator}
     * @return the builder
     */
    public Builder proxyAuthenticator(Authenticator proxyAuthenticator) {
      this.proxyAuthenticator = proxyAuthenticator;
      return this;
    }

  }

  private HttpConfigOptions(Builder builder) {
    this.disableSslVerification = builder.disableSslVerification;
    this.proxy = builder.proxy;
    this.proxyAuthenticator = builder.proxyAuthenticator;
  }
}
