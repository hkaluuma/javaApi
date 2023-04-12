
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TestApi2 {

    //variables
   private static Integer Fever=2, MuscleAches=1, LossOfsmell=0,PainfulBreathing=0,ShortnessOfBreath=0,
   JointAche=0,RunnyNose=1,OtherNeurologicalSigns=2, RelationshipWithContactPerson=5,Diabates=0,SoreThroat=1,
   LossOfTaste=0,Occupation=4,Diarrhoea=0,Vomiting=0,Nausea=1,Rash=2;

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8000/predict?Fever="+Fever+"&MuscleAches="+MuscleAches+"&LossOfsmell="+LossOfsmell+
        "&PainfulBreathing="+PainfulBreathing+"&ShortnessOfBreath="+ShortnessOfBreath+"&JointAche="+JointAche+
        "&RunnyNose="+RunnyNose+"&OtherNeurologicalSigns="+OtherNeurologicalSigns+"&RelationshipWithContactPerson="
        +RelationshipWithContactPerson+"&Diabetes="+Diabates+"&SoreThroat="+SoreThroat+"&LossOfTaste="+LossOfTaste+
        "&Occupation="+Occupation+"&Diarrhoea="+Diarrhoea+"&Vomiting="+Vomiting+"&Nausea="+Nausea+"&Rash="+Rash;
        Map<String, String> parameters = new HashMap<String,String>();
       /*parameters.put("Fever", "2");
        parameters.put("MuscleAches", "1");*/
        String response = sendPostRequest(url, parameters);
        System.out.println(response);
    }

    private static String sendPostRequest(String url, Map<String, String> parameters) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            String requestBody = buildRequestBody(parameters);
            byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
            connection.setRequestProperty("Content-Length", String.valueOf(requestBodyBytes.length));
            connection.getOutputStream().write(requestBodyBytes);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String buildRequestBody(Map<String, String> parameters) {
        StringBuilder requestBody = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            requestBody.append(entry.getKey());
            requestBody.append("=");
            requestBody.append(entry.getValue());
            requestBody.append("&");
        }
        return requestBody.toString();
    }


}

