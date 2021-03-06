package pblog.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pblog.entity.Note;
import pblog.entity.Visitor;
import pblog.service.NoteService;
import pblog.service.VisitorService;
import pblog.util.EmailSender;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
public class NoteAction extends BasicAction implements ServletRequestAware {

    /**
     *
     */
    private static final long serialVersionUID = -8218934505459563277L;

    private String mac;
    private int visitorId;
    private String name;
    private String email;
    private String content;
    private NoteService noteService;
    private VisitorService visitorService;
    private HttpSession session;
    private List<Note> noteList;
    private Map<Integer, Visitor> visitorMap;
    private Integer receiveNoteId;
    private int receiveId;
    //通过锚点跳转定位的noteId
    private String position;

    public String addNote() {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            String ip = (String) session.getAttribute("ip");
            visitorService.visitorRegister(name, email, ip);
            visitor = visitorService.getVisitor(ip);
            session.setAttribute("visitor", visitor);
        }
        noteService.addNote(content, visitor.getVisitorId(), receiveId,receiveNoteId);
        Visitor receiver=visitorService.getVisitorById(receiveId);
        EmailSender.send_note_response(receiver,visitor,receiveNoteId);
        return SUCCESS;
    }

    @Override
    public String execute() {
        noteList = noteService.getAllNote();
        return SUCCESS;
    }

    public NoteService getNoteService() {
        return noteService;
    }

    @Resource
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    public VisitorService getVisitorService() {
        return visitorService;
    }

    @Resource
    public void setVisitorService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        session = request.getSession();
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Map<Integer, Visitor> getVisitorMap() {
        return visitorMap;
    }

    public void setVisitorMap(Map<Integer, Visitor> visitorMap) {
        this.visitorMap = visitorMap;
    }

    public Integer getReceiveNoteId() {
        return receiveNoteId;
    }

    public void setReceiveNoteId(Integer receiveNoteId) {
        this.receiveNoteId = receiveNoteId;
    }

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
