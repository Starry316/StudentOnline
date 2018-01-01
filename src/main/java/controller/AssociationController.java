package controller;

import dao.IAssociationDao;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Starry on 2017/12/25.
 */
@Controller
@RequestMapping("/association")
public class AssociationController {
    @Resource(name = "associationDao")
    IAssociationDao associationDao;
    @RequestMapping("/getAssociations")
    public String getAssociations(){
        return null;
    }
}
