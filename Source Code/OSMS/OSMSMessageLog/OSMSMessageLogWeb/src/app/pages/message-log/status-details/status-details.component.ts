import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Settings } from '../../../app.settings.model';
import { AppSettings } from '../../../app.settings';
import { MessageLogRestService } from '../message-log-search-rest.service';
import { MessageLog_StatusDetails } from '../../../models/message-log/message-log-status-details.model';

@Component({
  selector: 'app-status-details',
  templateUrl: './status-details.component.html',
  styleUrls: ['./status-details.component.scss'],
  
})
export class StatusDetailsComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;
  public messgaeLogId: number;
  public statusDetailsDataSource: MatTableDataSource<any>;
  public statusDetailsList: Array<MessageLog_StatusDetails> = [];
  public displayedColumns = ['timestamp', 'status'];
	
  constructor(private messageLogRestService: MessageLogRestService) {
	}

  ngOnInit() {
   this.statusDetailsRestServiceCall(this.messgaeLogId);
  }

  statusDetailsRestServiceCall(messgaeLogId : number) {
		console.log("messgaeLogId::"+messgaeLogId)
		this.messageLogRestService.getStatusDetails(messgaeLogId)
			.subscribe(result => {
				console.log("result::" + JSON.stringify(result));
				result.statusLogs.forEach(entry => {
          var myObj = entry;
          console.log("myObj::" + myObj);
					let statusDetails = new MessageLog_StatusDetails();
					statusDetails.timestamp = myObj.insertDate;
					statusDetails.status = myObj.status;
					this.statusDetailsList.push(statusDetails);
				});
				this.statusDetailsDataSource = new MatTableDataSource<MessageLog_StatusDetails>(this.statusDetailsList);
				this.statusDetailsDataSource.paginator = this.paginator;
				this.statusDetailsDataSource.sort = this.sort;
			});
	}

}
