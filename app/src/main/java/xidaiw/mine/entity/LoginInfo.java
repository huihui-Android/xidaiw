package xidaiw.mine.entity;

import com.google.gson.Gson;

public class LoginInfo {

	/**
	 * code : 1
	 * data : {"sessionId":"548FE3EFFE2F117F2E8D21FBEFFC0601"}
	 * message : 登录成功
	 * success : true
	 */

	private int code;
	private DataBean data;
	private String message;
	private boolean success;

	public static LoginInfo objectFromData(String str) {

		return new Gson().fromJson(str, LoginInfo.class);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static class DataBean {
		/**
		 * sessionId : 548FE3EFFE2F117F2E8D21FBEFFC0601
		 */

		private String sessionId;

		public static DataBean objectFromData(String str) {

			return new Gson().fromJson(str, DataBean.class);
		}

		public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
	}
}
