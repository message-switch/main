import { Interval } from "./interval.model";

export class MessageLogSearchInput {
	public interval: number;
	public startDate: Date;
	public endDate: Date;
	public intervalValues: Array<Interval>;
	constructor(
	) { }

}