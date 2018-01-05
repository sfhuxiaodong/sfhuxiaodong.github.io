package hxd.view;

import hxd.util.FileUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;

/**
 * Created by Administrator on 2018/1/5.
 */
public class MainTable {
    private JSONArray sideBarJson;
    private JSONArray settingJson;
    public MainTable(){
        this.init();
    }
    public void init(){
        String sideBar= FileUtil.readJson(FileUtil.getRealPath(this.getClass())+"\\conf\\sideBar.json");
        sideBarJson=JSONArray.fromObject(sideBar);
//        String setting=FileUtil.readJson(FileUtil.getRealPath(this.getClass())+"\\conf\\setting.json");
//        settingJson=JSONArray.fromObject(setting);
        this.createTable();
    }
    private void createTable(){
        JFrame main=new JFrame();
        main.setSize(1200,700);
        main.setVisible(true);
        main.setContentPane(this.createSideBar());
        main.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        }
    private JPanel createSideBar(){
        JPanel sideBar=new JPanel();
        for(int i=0;i<sideBarJson.size();i++){
            JSONObject temp=sideBarJson.getJSONObject(i);
            JButton btn=new JButton(temp.getString("parent"));
            btn.setVisible(true);
            sideBar.add(btn);
        }
        sideBar.setVisible(true);
        return sideBar;
    }
}
