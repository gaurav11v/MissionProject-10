import { Component } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-marksheet-list',
  templateUrl: './marksheet-list.component.html',
  
})
export class MarksheetListComponent extends BaseListCtl{

  constructor(public locator:ServiceLocatorService, route: ActivatedRoute){
    super(locator.endpoints.MARKSHEET, locator, route);
  }

}
