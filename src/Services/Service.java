class Service implements PostCalls {

	public static args;

	//constructor
	public Service( String args_sent ) {
		args = args_sent;	
	}
			
	//POST requestBody
	public Post( String requestBody ){

		//escape the double quotes in json string
		String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"changeDetail\",\"params\":[{\"id\":11376}],\"id\":2}";
		
		//requestURL
		String requestUrl="https://git.eclipse.org/r/gerrit/rpc/ChangeDetailService";
		
		//declare or initialize instance variable
		PostCalls response = new PostCalls();
		
		//Perform POST call
		response = sendPostRequest(requestUrl, payload);

		//return response
		return response;
	}

}
