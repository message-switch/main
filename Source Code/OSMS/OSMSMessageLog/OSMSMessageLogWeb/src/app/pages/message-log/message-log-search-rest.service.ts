import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable'
import { environment } from '../../../environments/environment';

@Injectable()
export class MessageLogRestService {
	private headers = new Headers({ 'Content-Type': 'application/json' });
	private url = environment.osmsMessageRestURL;
	constructor(private httpClient: HttpClient) { }

	getMessageLogResultsAllParams(interval: number, startDateTime: Date,  endDateTime: Date): Observable<any> {
		let params;
		params = {'interval':interval, 'startDateTime': startDateTime, 'endDateTime': endDateTime };
		let url = this.url + 'rest/OSMSMessageLog/getByPeriod';
		return this.httpClient.post(url, params, { responseType: 'json' });
	}

	getStatusDetails(messageLogId: number): Observable<any> {
		let params;
		params = {'statusLog':{ 'messagelogId': messageLogId }};
		let url = this.url + 'rest/OSMSMessageLog/getAllStatusByLogId';
		return this.httpClient.post(url, params, { responseType: 'json' });
	}

	getMessageLogDetails(messageLogId: number): Observable<any> {
		let params;
		params = {'messageLog':{ 'messagelogId': messageLogId }};
		let url = this.url + 'rest/OSMSMessageLog/getByLogId';
		return this.httpClient.post(url, params, { responseType: 'json' });
	}

	getCodedIntervals(): Observable<any> {
		console.log("getCodedIntervals>>"+this.url);
		let url = this.url + 'rest/OSMSMessageLog/getCodedMsgLogIntevals';
		console.log("url2::>>" + url);
		return this.httpClient.post(url, { responseType: 'json' });
	}
	


}






