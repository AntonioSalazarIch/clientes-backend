package com.et.clientes.backend.security.auth;

public class JwtConfig {

	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "	MIIEpAIBAAKCAQEA3lWGlVP1EZGBJLkYPtX8QJ61CI27LjLMx5mAPlWa5zZWbVhl\n"
			+ "	gIYG25w4WcXjxSpikAKE2PPcj6QwVue73TJaaWZNB/1raMxDFc1hQ1JK3HTHvPwM\n"
			+ "	gH228f8pySDPjRipSlgBxkfenO9uCnmXMUduaooQKmibozlR314dyl0WwAGxsaQH\n"
			+ "	E5h55ES/hkBn4K5JEYMzI+jLSIUsUOiE6Bm/isY7pm270/PF7e8tNiQ5ihxFSHCY\n"
			+ "	ftO/hKtC69qz0E55o2f47vQKv6fOYjU3/+c/lgzGIynVXvl/0GL1ApSMLIAA6z91\n"
			+ "	IvrSggJqXszvFptlKRalJQCoWMj0hKdSrvDfjwIDAQABAoIBAAFQGfpZw5G1/UA9\n"
			+ "	Q5JjaxjqlwEU7S0JqcHn+yTjFoYVAQ+mPPs0T2gOlRqam4y3glt9WFF7pyrF+m8Y\n"
			+ "	8TgOKxCCRSQt7+tvgVnom5FtM/n3SpKoHl7H30OwkQuaAP/BTIae3GvSUtM0ar7v\n"
			+ "	FuB4noNMi2nksj6VgRFDmgNu50p89UAVrJ7VEiTvq+1mpRJ9ck0UDslwntxCUfIG\n"
			+ "	vE1tYbeo2qK7PqXImRC9QFs2/j1/zPpgwBhRt4/guIVyjuBEtlAn4pWIp1cR+8qj\n"
			+ "	dT4VGbavmCNF6ae4UonYTLOz0S2cW0Vdsm1yIIgEyXigCpO3hDIau+LZaWyarvd3\n"
			+ "	+hiBp7kCgYEA/SP4ZVnLQGKay9xvMnLJT3RPMkAgQ628m1wq0AwWqw92zg+APKPZ\n"
			+ "	vbh3IiBHl6aTekVNKSZHxqPQA1t82YIHNsZ7lEEulhe2lMsIjsfBvKLzMcAAzAXv\n"
			+ "	N+6ABTTVoIAAUMRk5O9A3np/TG/nDAQ2rDbdS11uECCQrBIhlm/OIdMCgYEA4Nh4\n"
			+ "	Otu+BpEACXHfctwFhtPewmEy1RRhPLduxUoHnWJ08C3UG/HCJxOF3x467PlWNBKI\n"
			+ "	VNcEcYoDVfGN7ZqfhHBOd5XM0Ml28GoHCMd3AsKbWZoIAlB0nHGJ7yQPCnsxtaCX\n"
			+ "	OhzeWc3AT+84cMrjybwHFUJqD/C07bittqKGedUCgYAI03E8r2XLx+RXyUbDPodQ\n"
			+ "	UuDUArJdSbhyvkLr4BAGRNLCmn3BH4FfAQh+UxvL6M3pjHMFRUVpYprFEzKGLudr\n"
			+ "	fH4gjClAqHEAPRf+Sm6x0giiqmwcsPRHQfSKue3c27mnF0HhTYo4d5Lqqlgm7hqt\n"
			+ "	5HfQweAthcUlirhLE3jfawKBgQDZEkPo1xL7NevqMmS+eAph45RQ5xPzQSyrOJCZ\n"
			+ "	qeH2IQKyihwYKmv928xH3uCWvhVqSmYSOk/Q6aRUydLzDG9qph4rN5U4EPhiHIrT\n"
			+ "	//Y21Pi0JZAL4+7gxoCbPp3CybLxHaxCb3J/ErPSuCouQsJtlbjk3myVHRcf1kbn\n"
			+ "	ZrsbTQKBgQCXMA3lkbRcYfgcie5dLeQnSdWUwYlwtRarnVtp2wd8grC6BRVu45iH\n"
			+ "	hfT5ElHYBZs8fE6Yf1ojpCC68a6Jtgy26Mssy/NJRUVTPmnhWfR4iwM4PNivTcSh\n"
			+ "	+QNReoOhQCu7HDA01G7WWTHZ55o5nrGXK7pAU2pa63aWv5WED/EORg==\n"
			+ "	-----END RSA PRIVATE KEY-----";

	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n"
			+ "	MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3lWGlVP1EZGBJLkYPtX8\n"
			+ "	QJ61CI27LjLMx5mAPlWa5zZWbVhlgIYG25w4WcXjxSpikAKE2PPcj6QwVue73TJa\n"
			+ "	aWZNB/1raMxDFc1hQ1JK3HTHvPwMgH228f8pySDPjRipSlgBxkfenO9uCnmXMUdu\n"
			+ "	aooQKmibozlR314dyl0WwAGxsaQHE5h55ES/hkBn4K5JEYMzI+jLSIUsUOiE6Bm/\n"
			+ "	isY7pm270/PF7e8tNiQ5ihxFSHCYftO/hKtC69qz0E55o2f47vQKv6fOYjU3/+c/\n"
			+ "	lgzGIynVXvl/0GL1ApSMLIAA6z91IvrSggJqXszvFptlKRalJQCoWMj0hKdSrvDf\n"
			+ "	jwIDAQAB\n"
			+ "	-----END PUBLIC KEY-----";
}
