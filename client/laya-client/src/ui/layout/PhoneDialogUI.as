/**Created by the LayaAirIDE,do not modify.*/
package ui.layout {
	import laya.ui.*;
	import laya.display.*;

	public class PhoneDialogUI extends View {
		public var mainSprite:Sprite;
		public var oneStep:Sprite;
		public var phoneInput:Label;
		public var twoStep:Sprite;
		public var codeBtn:Button;
		public var codeInput:Label;
		public var inputSprite:Sprite;
		public var nextBtn:Button;
		public var resumeBtn:Button;

		public static var uiView:Object ={"type":"View","props":{"y":0,"x":0,"width":1435,"text":"手机号：","label":"下一步","height":650},"child":[{"type":"Sprite","props":{"y":0,"x":0,"width":1255,"var":"mainSprite","height":642},"child":[{"type":"Sprite","props":{"y":0,"x":151,"width":953,"var":"oneStep","height":167},"child":[{"type":"Label","props":{"y":50,"x":65,"width":230,"text":"手机号：","height":71,"fontSize":64,"color":"#c95a46","bold":true,"align":"center"}},{"type":"TextInput","props":{"y":34,"x":314,"width":581,"type":"text","skin":"base/number_bg.png","sizeGrid":"11,12,11,12","maxChars":13,"height":102,"fontSize":64,"editable":false,"color":"#ffffff","align":"center"}},{"type":"Label","props":{"y":52,"x":334,"width":539,"var":"phoneInput","text":"00000000000000","height":64,"fontSize":64,"color":"#ffffff","align":"center"}}]},{"type":"Sprite","props":{"y":0,"x":107.5,"width":1040,"var":"twoStep","height":167},"child":[{"type":"TextInput","props":{"y":33,"x":300,"width":472,"type":"text","skin":"base/number_bg.png","sizeGrid":"11,12,11,12","height":102,"fontSize":64,"editable":false,"color":"#ffffff","align":"center"}},{"type":"Label","props":{"y":54,"x":50,"width":232,"text":"验证码：","height":63,"fontSize":64,"color":"#c95a46","bold":true,"align":"center"}},{"type":"Button","props":{"y":37,"x":797,"width":198,"var":"codeBtn","skin":"base/btn_basic.png","labelSize":40,"labelPadding":"0,0,3,0","labelColors":"#FFFFFF,#FFFFFF,#FFFFFF","labelBold":true,"label":"重新获取","height":95,"sizeGrid":"12,10,10,10"}},{"type":"Label","props":{"y":50,"x":317,"width":443,"var":"codeInput","text":"0000","height":67,"fontSize":64,"color":"#000000","align":"center"}}]},{"type":"Sprite","props":{"y":171,"x":21,"var":"inputSprite"},"child":[{"type":"Button","props":{"y":149,"x":982,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":85,"skin":"base/number/win/0.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":0,"x":0,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":97,"skin":"base/number/win/1.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":0,"x":246,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":87,"skin":"base/number/win/2.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":0,"x":491,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":86,"skin":"base/number/win/3.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":0,"x":735,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":84,"skin":"base/number/win/4.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":0,"x":983,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":87,"skin":"base/number/win/5.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":149,"x":0,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":86,"skin":"base/number/win/6.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":149,"x":247,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":86,"skin":"base/number/win/7.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":149,"x":491,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":86,"skin":"base/number/win/8.png","mouseEnabled":false}}]},{"type":"Button","props":{"y":149,"x":736,"width":230,"skin":"base/btn_basic.png","height":140,"sizeGrid":"12,10,10,10"},"child":[{"type":"Image","props":{"y":25,"x":86,"skin":"base/number/win/9.png","mouseEnabled":false}}]}]},{"type":"Button","props":{"y":498,"x":253,"width":300,"var":"nextBtn","skin":"base/btn_danger.png","scaleY":1.2,"scaleX":1.2,"labelSize":40,"labelPadding":"0,0,6,0","labelColors":"#FFFFFF,#FFFFFF,#FFFFFF","labelBold":"true","label":"下一步","height":95,"sizeGrid":"31,71,40,71"}},{"type":"Button","props":{"y":498,"x":647,"width":300,"var":"resumeBtn","skin":"base/btn_normal.png","scaleY":1.2,"scaleX":1.2,"labelSize":40,"labelPadding":"0,0,6,0","labelColors":"#FFFFFF,#FFFFFF,#FFFFFF","labelBold":"true","label":"重新输入","height":95,"sizeGrid":"31,71,40,71"}}]}]};
		override protected function createChildren():void {
			super.createChildren();
			createView(uiView);
		}
	}
}