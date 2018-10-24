import { Component, OnInit, ViewChild, ChangeDetectorRef, Inject } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { MatDialog } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';
import { AppSettings } from '../../app.settings';
import { Settings } from '../../app.settings.model';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { MessageLogRestService } from './message-log-search-rest.service';
import { MessageLogSearchInput } from '../../models/message-log/message-log-search-input.model';
import { MessageLog } from '../../models/message-log/message-log.model';
import { StatusDetailsComponent } from './status-details/status-details.component';
import { DetailsComponent } from './details/details.component';
import { Interval } from '../../models/message-log/interval.model';

@Component({
	selector: 'app-message-log',
	templateUrl: './message-log.component.html',
	styleUrls: ['./message-log.component.scss'],
	animations: [
		trigger('detailExpand', [
			state('collapsed', style({ height: '0px', minHeight: '0', display: 'none' })),
			state('expanded', style({ height: '*' })),
			transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
		]),
	],
})
export class MessageLogComponent implements OnInit {
	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;
	public settings: Settings;
	public messageLogSearchInput: MessageLogSearchInput;
	public messageLogDataSource: MatTableDataSource<any>;

	expandedElement: MessageLog
	public displayedColumns = ['correlationId', 'mke', 'ori', 'system', 'fbi', 'sid', 'inOut', 'responseTime', 'timestamp', 'status', 'details'];
	showMsgLog: boolean = false;
	messageLogList: Array<MessageLog>;
	showDates: boolean = false;
	error: any = { isError: false, errorMessage: '' };

	constructor(public appSettings: AppSettings, private messageLogRestService: MessageLogRestService,
		public dialog: MatDialog,
		public router: Router, private route: ActivatedRoute) {
		this.settings = this.appSettings.settings;
	}

	ngOnInit() {
		this.messageLogSearchInput = new MessageLogSearchInput();
		this.showMsgLog = false;
		this.showDates = true;
		let intevalValues: Array<Interval> = [];
		this.messageLogRestService.getCodedIntervals()
			.subscribe(result => {
				console.log("getCodedIntervals result>>" + result);
				result.forEach(entry => {
					let interval = new Interval();
					interval.code = entry.INTERVAL_CODE;
					interval.value = entry.INTERVAL_DESC;
					intevalValues.push(interval);

				});
				this.messageLogSearchInput.intervalValues = intevalValues;
			});
	}

	changeInterval() {
		if (this.messageLogSearchInput.interval == -1) {
			this.showDates = true;
		} else {
			this.showDates = false;
		}
	}

	applyFilter(filterValue: string) {
		filterValue = filterValue.trim();
		filterValue = filterValue.toLowerCase();
		this.messageLogDataSource.filter = filterValue;
	}

	onSubmit(): void {
		console.log("onSubmit>>");
		this.messageLogList = [];
		let startDate = this.messageLogSearchInput.startDate;
		let endDate = this.messageLogSearchInput.endDate;
		this.error = { isError: false, errorMessage: '' };
		this.validateInputs();
		if (!this.error.isError) {
			if (startDate != null && endDate != null) {
				this.onSubmitRestServiceCall();
			} else {
				this.onSubmitRestServiceCall();
			}
			this.showMsgLog = true;
		}
	}

	validateInputs() {
		if (this.messageLogSearchInput.interval == null && 
			(this.messageLogSearchInput.startDate == null || this.messageLogSearchInput.endDate == null)) {
				this.error = { isError: true, errorMessage: 'Please choose eiether Interval or enter dates'};
		}else if (this.messageLogSearchInput.interval == null || this.messageLogSearchInput.interval == -1) {
			if (this.messageLogSearchInput.startDate == null || this.messageLogSearchInput.endDate == null) {
				this.error = { isError: true, errorMessage: 'Please enter both start date and end date' };
			} else if (new Date(this.messageLogSearchInput.endDate) < new Date(this.messageLogSearchInput.startDate)) {
				this.error = { isError: true, errorMessage: 'Start date should be greater than end date' };
			}
		}
	}


	onSubmitRestServiceCall() {
		let interval = this.messageLogSearchInput.interval;
		let startDate = this.messageLogSearchInput.startDate;
		let endDate = this.messageLogSearchInput.endDate;
		this.messageLogRestService.getMessageLogResultsAllParams(interval, startDate, endDate)
			.subscribe(result => {
				console.log("result::" + JSON.stringify(result));
				result.messageLogs.forEach(entry => {
					var myObj = entry;
					let messageLog = new MessageLog();
					messageLog.messagelogId = myObj.messagelogId;
					messageLog.correlationId = myObj.correlationId;
					messageLog.mke = myObj.messageKey;
					messageLog.ori = myObj.ori;
					messageLog.system = myObj.system;
					messageLog.fbi = myObj.fbiNumber;
					messageLog.sid = myObj.stateId;
					messageLog.inOut = myObj.messageLogType;
					messageLog.responseTime = myObj.responseTime;
					//messageLog.timestamp =myObj.timestamp;
					messageLog.status = myObj.status;
					this.messageLogList.push(messageLog);
				});

				this.messageLogDataSource = new MatTableDataSource<MessageLog>(this.messageLogList);
				this.messageLogDataSource.paginator = this.paginator;
				this.messageLogDataSource.sort = this.sort;

			});
	}

	getStatusDetails(messgaeLogId: number) {
		console.log("getStatusDetails messgaeLogId::" + messgaeLogId)
		let dialogRef = this.dialog.open(StatusDetailsComponent, { position: { left: '30%', top: '10%', right: '25%' } });
		dialogRef.componentInstance.messgaeLogId = messgaeLogId;
		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');
		});
	}

	getDetails(messgaeLogId: number) {
		console.log("getDetails messgaeLogId::" + messgaeLogId)
		let dialogRef = this.dialog.open(DetailsComponent, { position: { left: '30%', top: '10%', right: '25%' } });
		dialogRef.componentInstance.messgaeLogId = messgaeLogId;
		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');
		});
	}

	reset() {
		this.showMsgLog = false;
		this.messageLogSearchInput = new MessageLogSearchInput();

	}

}


