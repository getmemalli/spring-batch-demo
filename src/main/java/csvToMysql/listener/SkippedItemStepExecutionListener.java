package csvToMysql.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

public class SkippedItemStepExecutionListener extends StepExecutionListenerSupport {

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        int skipped = stepExecution.getSkipCount(); // Total for read+write+process
        stepExecution.setReadCount(0);
        stepExecution.setWriteCount(0);
        stepExecution.setCommitCount(0);
        // Log it to somewhere.
        return null;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        int skipped = stepExecution.getSkipCount(); // Total for read+write+process
        stepExecution.setReadCount(0);
        stepExecution.setWriteCount(0);
        stepExecution.setCommitCount(0);
        // Log it to somewhere.
    }
}
