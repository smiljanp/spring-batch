package org.springframework.batch.core.job.flow;


/**
 * @author Dave Syer
 * 
 */
public class DecisionState extends AbstractState {

	private final JobExecutionDecider decider;

	/**
	 * @param name
	 */
	DecisionState(JobExecutionDecider decider, String name) {
		super(name);
		this.decider = decider;
	}

	@Override
	public String handle(JobFlowExecutor executor) throws Exception {
		return decider.decide(executor.getJobExecution(), executor.getStepExecution());
	}

}