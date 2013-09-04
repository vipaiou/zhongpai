package com.supertool.dspui.dao.dialect;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class Mysqldialect extends MySQLDialect {
    public Mysqldialect() {
        super();
//		registerFunction("get_class_ids_for_media", new StandardSQLFunction("get_class_ids_for_media", StandardBasicTypes.STRING) );
//		registerFunction("get_class_names_for_media", new StandardSQLFunction("get_class_names_for_media", StandardBasicTypes.STRING) );
//		registerFunction("get_class_like_for_media", new StandardSQLFunction("get_class_like_for_media", StandardBasicTypes.STRING) );
//		registerFunction("get_gbk_str", new StandardSQLFunction("get_gbk_str", StandardBasicTypes.STRING) );
        registerKeyword("utf-8");
    }
}

