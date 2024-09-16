/****** Script for SelectTopNRows command from SSMS  ******/
DElete
  FROM [Mobile_operator].[dbo].[Calling]

  delete
  FROM [Mobile_operator].[dbo].[SMS]

  delete
  FROM [Mobile_operator].[dbo].[Client]

  delete
  FROM [Mobile_operator].[dbo].[Company]
  delete
  FROM [Mobile_operator].[dbo].[TariffPlan]