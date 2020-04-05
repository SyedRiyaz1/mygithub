package OTP;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class Test129_Get_VirtualContactNumber 
{

	public static void main(String[] args) 
	{
	final String  ACCOUNT_SID	="AC491c8b8881e6f8d1946d948b3e5a2cfb";
	final String  AUTH_TOKEN   =  "5f086b2660baaa294db5a5f9fbd3c26f";
	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	ResourceSet<Message>msg=Message.reader().read();
	System.out.println("all message is:"+msg);
	for(Message record:msg)
	{
		System.out.println(record.getFrom()+"=========="+record.getBody());
	}
	}

}
