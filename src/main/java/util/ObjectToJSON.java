package util;

/**
 * Created by 11314 on 2017/12/25.
 */

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @return json
 */
public class ObjectToJSON {
    public JSONArray  ListToJSON(List list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray;
    }
}
