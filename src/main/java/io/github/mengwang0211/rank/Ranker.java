package io.github.mengwang0211.rank;

import io.github.mengwang0211.entity.Head;
import io.github.mengwang0211.entity.Sheet;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ranker
 */
public class Ranker {

    /**
     * Execute sheet list
     *
     * @param list list
     * @return the list
     */
    public static List<Sheet> executeSheet(List<Sheet> list){

        Collections.sort(list, new Comparator<Sheet>() {
            @Override
            public int compare(Sheet o1, Sheet o2) {
                if (o1.getOrder() > o2.getOrder()) {
                    return 1;
                }
                if (o1.getOrder() == o2.getOrder()) {
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }

    /**
     * Execute head list
     *
     * @param list list
     * @return the list
     */
    public static List<Head> executeHeadRowIndex(List<Head> list){

        Collections.sort(list, new Comparator<Head>() {
            @Override
            public int compare(Head o1, Head o2) {
                if (o1.getFromRowIndex() > o2.getFromRowIndex()) {
                    return 1;
                }
                if (o1.getFromRowIndex() == o2.getFromRowIndex()) {
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }

    /**
     * Execute head from index list
     *
     * @param list list
     * @return the list
     */
    public static List<Head> executeHeadFromColIndex(List<Head> list){

        Collections.sort(list, new Comparator<Head>() {
            @Override
            public int compare(Head o1, Head o2) {
                if (o1.getFromColIndex() > o2.getFromColIndex()) {
                    return 1;
                }
                if (o1.getFromColIndex() == o2.getFromColIndex()) {
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }

}
