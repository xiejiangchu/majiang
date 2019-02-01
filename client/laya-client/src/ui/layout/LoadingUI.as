/**Created by the LayaAirIDE,do not modify.*/
package ui.layout {
	import laya.ui.*;
	import laya.display.*;

	public class LoadingUI extends View {
		public var bg:Image;
		public var progressBar:ProgressBar;
		public var progressBarLabel:Label;

		public static var uiView:Object ={"type":"View","props":{"width":600,"height":1080},"child":[{"type":"Image","props":{"y":-366,"x":-450,"width":1920,"var":"bg","skin":"ui/loading/bg.jpg","height":"1080"}},{"type":"ProgressBar","props":{"y":999,"x":346,"var":"progressBar","skin":"ui/loading/progress.png","sizeGrid":"11,7,12,7"}},{"type":"Label","props":{"y":1002,"x":346,"width":252,"var":"progressBarLabel","text":"加载中 100%","height":38,"fontSize":24,"color":"#ffffff","align":"center"}}]};
		override protected function createChildren():void {
			super.createChildren();
			createView(uiView);
		}
	}
}