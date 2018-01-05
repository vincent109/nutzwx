package org.nutz.weixin.spi;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.nutz.lang.Each;
import org.nutz.resource.NutResource;
import org.nutz.weixin.bean.WxGroup;
import org.nutz.weixin.bean.WxMenu;
import org.nutz.weixin.bean.WxOutMsg;
import org.nutz.weixin.bean.WxTemplateData;
import org.nutz.weixin.bean.WxUser;

/**
 * 封装weixin的API
 *  @author wendal(wendal1985@gmail.com)
 */
@Deprecated
public interface WxAPI {

	void send(WxOutMsg out);
	
	//---------------------------------------------------
	
	WxGroup createGroup(WxGroup group);
	
	List<WxGroup> listGroup();
	
	int userGroup(String openid);
	
	void renameGroup(WxGroup group);
	
	void moveUser2Group(String openid, String groupid);
	
	//-----------------------------------------------
	
	WxUser fetchUser(String openid, String lang);
	
	void listWatcher(Each<String> each);
	
	//----------------------------------------------
	
	void creatMenu(WxMenu menu);
	
	WxMenu fetchMenu();
	
	void clearMenu();
	
	//------------------------------------------------
	
	String tmpQr(int expire_seconds, String scene_id);
	
	String godQr(int scene_id);
	
	String qrUrl(String ticket);
	
	String getAccessToken();
	
	//------------------------------------------------
	
	String mediaUpload(String type, File f);
	
	NutResource mediaGet(String mediaId);
	
	String sendTemplateMsg(String touser, String template_id, String topcolor, Map<String, WxTemplateData> data);
	
	void userRemark(String openid, String remark);
}
