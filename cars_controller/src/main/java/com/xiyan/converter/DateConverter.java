package com.xiyan.converter;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.springframework.core.convert.converter.Converter;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @antuor binwang
 * @date 2018/3/7  20:45
 */
public class DateConverter implements Converter<String, Date> {

    private static class PatternClass {
        private Integer matchLength;
        private String pattern;

        public PatternClass(int matchLength, String pattern) {
            this.matchLength = matchLength;
            this.pattern = pattern;
        }

        public Integer getMatchLength() {
            return this.matchLength;
        }

        public void setMatchLength(Integer matchLength) {
            this.matchLength = matchLength;
        }

        public String getPattern() {
            return this.pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    private static PatternClass[] supportPatterns = new PatternClass[]{new PatternClass(19, "yyyy-MM-dd HH:mm:ss"), new PatternClass(19, "yyyy-MM-dd'T'HH:mm:ss"), new PatternClass(10, "yyyy-MM-dd"), new PatternClass(16, "yyyy-MM-dd HH:mm"),

            new PatternClass(18, "yyyy-M-dd HH:mm:ss"), new PatternClass(18, "yyyy-M-dd'T'HH:mm:ss"), new PatternClass(9, "yyyy-M-dd"), new PatternClass(15, "yyyy-M-dd HH:mm"),

            new PatternClass(17, "yyyy-M-d HH:mm:ss"), new PatternClass(17, "yyyy-M-d'T'HH:mm:ss"), new PatternClass(8, "yyyy-M-d"), new PatternClass(14, "yyyy-M-d HH:mm")};

    @Override
    public Date convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        int length = s.length();
        for (PatternClass pattern : supportPatterns) {
            if (length != pattern.getMatchLength()) {
                continue;
            }
            DateFormat simpleDateFormat = new SimpleDateFormat(pattern.getPattern());

            try {
                return simpleDateFormat.parse(s);
            } catch (Exception e) {
                continue;
            }
        }
        return null;
    }
}


