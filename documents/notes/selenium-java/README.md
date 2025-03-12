# 📚Notatki - wszystko, co warto pamiętać i z czym były problemy

### @FindBy - "lokator" vs 'lokator'

Link: https://stackoverflow.com/questions/5606664/too-many-characters-in-character-literal-error

W języku C# i wychodzi na to, że w języku Java też jest tak, że:  
`myChar = '='` - pojedyncze apostrofy są dla pojedynczych znaków  
`myString = "=="` - cudzysłowie jest dla całych łańcuchów znaków

### Xpath - znajdowanie po tekście

Element "zawiera" fragment tekstu:
```Java
@FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Alerts, Frame & Windows')]")  
private WebElement alertsFrameWindowsButton;
```

Element ma dokładnie taki tekst:
```Java
@FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Links']")  
private WebElement linksButton;
```
