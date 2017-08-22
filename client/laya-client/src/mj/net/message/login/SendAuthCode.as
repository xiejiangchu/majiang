package mj.net.message.login
{
	import com.isnowfox.core.io.Input;
	import com.isnowfox.core.io.Output;
	import com.isnowfox.core.io.message.Message;
	

	import laya.utils.*;
	
	/**
 	 * 发送验证码
 	 * 
 	 * <b>生成器生成代码，请勿修改，扩展请继承</b>
 	 * @author isnowfox消息生成器
 	 */
	public class SendAuthCode implements Message
	{
		public static const TYPE:int				=7;
		public static const ID:int					=21;
		
		public static function create(phone:String):SendAuthCode
		{
			const sendAuthCode:SendAuthCode = new SendAuthCode();
			sendAuthCode._phone = phone;
			return sendAuthCode;
		}
	
		protected var _phone:String;
		
		public function SendAuthCode()
		{
		}
			
		public function decode(in0:Input):void
		{
			_phone = in0.readString();
		}
		
		public function encode(out:Output):void
		{
			out.writeString(phone);
		}
		

		public function get phone():String
		{
			return _phone;
		}
		public function set phone(phone:String):void
		{
			_phone = phone;
		}
		
		public function toString():String
		{
			return "SendAuthCode [phone=" + _phone + ", ]";
		}
		
		public function getMessageType():int
		{
			return TYPE;
		}
		
		public function getMessageId():int
		{
			return ID;
		}
	}
}
