class BaseService implements PostCalls {

	public static String args;

	//constructor
	public String BaseService( String args_sent ) {
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
		response = response.sendPostRequest(requestUrl, payload);

		//return response
		return response;
	}

}
