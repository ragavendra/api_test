class Service {

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
		
		//Perform POST call
		response = sendPostRequest(requestUrl, payload);
	}

	//POST action
	public static String sendPostRequest(String requestUrl, String payload) {
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonString = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();
			connection.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return jsonString.toString();
	}

}
