//import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestApi {
    public static void main(String[] args) {
        //DssController dssobj =  new DssController();
        System.out.println("...................: ");
        //System.out.println(dssobj.postPrediction());
        //ystem.out.println(postPrediction());
        System.out.println(postPrediction2());
    }


    	public static String postPrediction(){
		String response_string= null;
		String command = "curl -X POST http://127.0.0.1:8000/predict --data Fever=2&MuscleAches=1&LossOfsmell=0&PainfulBreathing=0&ShortnessOfBreath=0&JointAche=0&RunnyNose=1&OtherNeurologicalSigns=2&RelationshipWithContactPerson=5&Diabetes=0&SoreThroat=1&LossOfTaste=0&Occupation=48&Diarrhoea=0&Vomiting=0&Nausea=1&Rash=2";
        Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			//BufferedInputStream response = process.getInputStream();
			response_string = String.valueOf(process);
			//process.destroy();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response_string;
    }

    // public static String newpostPrediction(){
    //     OkHttpClient client = new OkHttpClient().newBuilder().build();
    //     MediaType mediaType = MediaType.parse("text/plain");
    //     RequestBody body = RequestBody.create(mediaType, "");
    //     Request request = new Request.Builder()
    //     .url("http://127.0.0.1:8000/predict?Fever=2&MuscleAches=1&LossOfsmell=0&PainfulBreathing=0&ShortnessOfBreath=0&JointAche=0&RunnyNose=1&OtherNeurologicalSigns=2&RelationshipWithContactPerson=5&Diabetes=0&SoreThroat=1&LossOfTaste=0&Occupation=48&Diarrhoea=0&Vomiting=0&Nausea=1&Rash=2")
    //     .method("POST", body).build();
    //     Response response = client.newCall(request).execute();
    //     return response;
    // }

    // public static String postPredictionfresh(){
    //     Unirest.setTimeouts(0, 0);
    //     HttpResponse<String> response = Unirest.post("http://127.0.0.1:8000/predict?Fever=2&MuscleAches=1&LossOfsmell=0&PainfulBreathing=0&ShortnessOfBreath=0&JointAche=0&RunnyNose=1&OtherNeurologicalSigns=2&RelationshipWithContactPerson=5&Diabetes=0&SoreThroat=1&LossOfTaste=0&Occupation=48&Diarrhoea=0&Vomiting=0&Nausea=1&Rash=2")
    //       .asString();
    //     return response;
    // }


    public static String postPrediction2(){
		String response_string= null;
		String command = "curl -X GET http://127.0.0.1:8000/predict?Fever=2&MuscleAches=1&LossOfsmell=0&PainfulBreathing=0&ShortnessOfBreath=0&JointAche=0&RunnyNose=1&OtherNeurologicalSigns=2&RelationshipWithContactPerson=5&Diabetes=0&SoreThroat=1&LossOfTaste=0&Occupation=48&Diarrhoea=0&Vomiting=0&Nausea=1&Rash=2";
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        //processBuilder.directory(new File("/home/"));
        Process process;
        try {
            process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            //int exitCode = process.exitValue();
            processBuilder.command(
            new String[]{"curl", "-X", "GET", "http://127.0.0.1:8000/predict?Fever=2&MuscleAches=1&LossOfsmell=0&PainfulBreathing=0&ShortnessOfBreath=0&JointAche=0&RunnyNose=1&OtherNeurologicalSigns=2&RelationshipWithContactPerson=5&Diabetes=0&SoreThroat=1&LossOfTaste=0&Occupation=48&Diarrhoea=0&Vomiting=0&Nausea=1&Rash=2"});
            //response_string = String.valueOf(process);
            response_string =String.valueOf(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
		return response_string;
    }

    
}
