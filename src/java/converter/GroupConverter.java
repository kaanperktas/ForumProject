/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.GroupDao;
import entity.SystemGroup;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author CASPER
 */
@FacesConverter("groupConverter")
public class GroupConverter implements Converter{

    private GroupDao gdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        return this.getGdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        SystemGroup sg=(SystemGroup) t;
        return String.valueOf(sg.getId());
    }

    public GroupDao getGdao() {
        if(this.gdao==null){
            this.gdao=new GroupDao();
        }
        return gdao;
    }

    public void setGdao(GroupDao gdao) {
        this.gdao = gdao;
    }
    
}
