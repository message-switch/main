import { Component, OnInit } from '@angular/core';
import { Settings } from '../../../app.settings.model';
import { MessageLogRestService } from '../message-log-search-rest.service';
import { MessageLogDetails } from '../../../models/message-log/message-log-details.model';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {
  public settings: Settings;
  public messgaeLogId: number;
  public messageLogDetailsDataSource: MatTableDataSource<any>;
  public messageLogDetailsList: Array<MessageLogDetails> = []; ;
  public displayedColumns1 = ['header'];
  public displayedColumns2 = ['payload'];

  constructor(private messageLogRestService: MessageLogRestService) {
  }

  ngOnInit() {
    this.messageDetailsRestServiceCall(this.messgaeLogId);
  }

  messageDetailsRestServiceCall(messgaeLogId: number) {
    console.log("messageDetailsRestServiceCall messgaeLogId::" + messgaeLogId)
    this.messageLogRestService.getMessageLogDetails(messgaeLogId)
      .subscribe(result => {
        console.log("messageDetailsRestServiceCall result::" + JSON.stringify(result));
          var myObj = result.messageLog;
          console.log("myObj::" + myObj);
          let messageLogDetails = new MessageLogDetails();
          messageLogDetails.header = myObj.header;
          messageLogDetails.payload = myObj.message;
          this.messageLogDetailsList.push(messageLogDetails);
        this.messageLogDetailsDataSource = new MatTableDataSource<MessageLogDetails>(this.messageLogDetailsList);
      });
  }

}
