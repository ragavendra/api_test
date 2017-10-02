public class PostCalls {

	  public PostCalls(opts) {
		@opts = opts
		@pollingPath = ''     
		@resourePath = ''     
		//@httpClient = HttpClient.new
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

	  public String URL() {
		  return GetPathPrefix() + @resourcePath   
	  }
	  
	  public String GetPollingPath() {
		  return GetPathPrefix() + @pollingPath
	  }
		  
	  public String GetPathPrefix() {
		  return @opts[:protocol] + '://' + @opts[:host] + ':' + @opts[:port]
	  }
}
