package eu.spyros.survey.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
public interface Identifiable {
    /**
     * @param identifiables
     *
     * @return
     */
    public static List<String> toStrings(final Collection<? extends Identifiable> identifiables) {

        if (identifiables == null) {
            return null;
        } else {
            final ArrayList<String> list = new ArrayList<>();
            Identifiable.toStrings(identifiables).stream().forEachOrdered(list::add);
            return list;
        }

    }

    /**
     * @param identifiables
     *
     * @return
     */
    public static String toString(final Collection<? extends Identifiable> identifiables) {

        if (identifiables == null) {
            return null;
        } else {
            final StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
            Identifiable.toStrings(identifiables).stream().forEachOrdered(stringJoiner::add);
            return stringJoiner.toString();
        }

    }

    /**
     * @param identifiable
     *
     * @return
     */
    public static String toString(final Identifiable identifiable) {
        if (identifiable == null) {
            return null;
        } else {
            return "" + identifiable.getId();
        }
    }

    /**
     * @return
     */
    public Long getId();
}
