import { Component } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
 
})
export class SubjectListComponent extends BaseListCtl{

  constructor(public locator:ServiceLocatorService, route:ActivatedRoute){
    super(locator.endpoints.SUBJECT, locator, route);
  }

}
