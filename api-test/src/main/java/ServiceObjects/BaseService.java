class BaseService extends PostCalls {

	public static String args;

	//constructor
	public BaseService( String args_sent ) {
		//super("hellohi");
		args = args_sent;	
	}
			
	//POST requestBody
	public String Post( String requestBody ){

		//escape the double quotes in json string
		requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"changeDetail\",\"params\":[{\"id\":11376}],\"id\":2}";
		
		//requestURL
		String requestUrl="https://git.eclipse.org/r/gerrit/rpc/ChangeDetailService";
		
		//declare or initialize instance variable
		PostCalls response = new PostCalls();
		
		//Perform POST call
		String resp = response.sendPostRequest(requestUrl, requestBody);

		//return response
		return resp.toString();
	}

}
