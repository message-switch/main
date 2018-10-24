// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  camsDashboardURL: 'http://camssrvr1.gcomsoft.local:8080/CAMSREST/rest/',
  camsUserManagementURL: 'http://10.0.200.143:8080/CAMSUserManagementREST/rest/CAMSUserMgmt/',
  camsCalendarRWSURL: 'http://camssrvr1.gcomsoft.local/CAMSCalendarREST/rest/CAMSEventMgmt/',
  chatRestUrl: 'ws://10.0.200.143:8080/CAMSChatREST/ws/SecureMessaging',
  dashboardRestUrl: 'http://camssrvr1.gcomsoft.local/CAMSWorkflowREST/rest/CAMSTechnicalDashboard/',
  camsCorrespondenceURL: 'http://camssrvr1.gcomsoft.local/CAMSCorrespondenceREST/rest',
  camsApplicationURL: 'http://localhost:8881/CAMSTimesheetREST/rest/TimesheetDashboard/',
  CAMSDesignerURL: 'http://camssrvr1.gcomsoft.local/CAMSDesignerREST/rest/',
  camsAuditRESTURL: 'http://camssrvr1.gcomsoft.local/CAMSAuditREST/',
  logoutURL:'http://mawfcsrvr1.gcomsoft.local:8080/openam/UI/Logout?realm=cams',
  camsAuditPaginatedURL:'http://camssrvr1.gcomsoft.local/CAMSAuditREST/rest/CAMSAuditMgmt/searchAuditPaginated',
  //camsContactRestURL: 'http://camssrvr1.gcomsoft.local:8080/CAMSContactREST/',
  camsRefTableMaintenanceURL: 'http://camsprod01.gcomsoft.local:8080/CAMSRefTableMaintenanceREST/rest/',
  osmsMessageRestURL: 'http://localhost:8080/OSMSMessageLogREST/'
};
