package science.doing.jctools.graal;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "org.jctools.queues.ConcurrentSequencedCircularArrayQueue")
final class Target_org_jctools_queues_ConcurrentSequencedCircularArrayQueue {
    @Alias
    @RecomputeFieldValue(kind = Kind.ArrayIndexScale, declClass = Object[].class)
    private static int ELEMENT_SHIFT;

    @Alias
    @RecomputeFieldValue(kind = Kind.ArrayIndexScale, declClass = Object[].class)
    protected static int SEQ_BUFFER_PAD;
}

@TargetClass(className = "org.jctools.util.UnsafeRefArrayAccess")
final class Target_org_jctools_util_UnsafeRefArrayAccess {
    @Alias
    @RecomputeFieldValue(kind = Kind.ArrayIndexShift, declClass = Object[].class)
    public static int REF_ELEMENT_SHIFT;

}

public class JCToolsSubstitutions {

}