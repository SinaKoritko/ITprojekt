package com.hdm.itprojekt.client.gui;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hdm.itprojekt.shared.LoginInfo;

public interface LoginServiceAsync {
	public void login (String requestUri, AsyncCallback<LoginInfo> async);
}
