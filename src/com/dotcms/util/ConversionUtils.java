package com.dotcms.util;

import java.io.Serializable;
import java.util.List;

/**
 * Utility class for conversion operations.
 * 
 * @author jsanca
 * @version 3.7
 * @since Jun 8, 2016
 */
public class ConversionUtils implements Serializable {

    public static ConversionUtils INSTANCE =
            new ConversionUtils();

    private ConversionUtils() {}

	/**
	 * Converts from the Original to Destiny bean using a converter.
	 * 
	 * @param origin
	 *            - origin
	 * @param converter
	 *            - {@link Converter}
	 * @param <O>
	 * @param <D>
	 * @return D
	 */
    public <O, D> D convert (final O origin,
                             final Converter<O, D> converter) {

        D d = null;

        if (null != origin && null != converter) {

            d = converter.convert(origin);
        }

        return d;
    } // convert

	/**
	 * Converts from the list of Original objects to Destiny beans using a
	 * converter.
	 * 
	 * @param originList - 
	 * @param converter - 
	 * @return
	 */
    public <O, D> List<D> convert (final O [] originList,
                                   final Converter<O, D> converter) {

        List<D> destinyList = null;

        if (null != originList && null != converter) {

            destinyList = CollectionsUtils.getNewList();

            for (O origin : originList) {

                destinyList.add(converter.convert(origin));
            }
        }

        return destinyList;
    } // convert

} // E:O:F:ConversionUtils.
