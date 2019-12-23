package uk.ac.warwick.example.repositories

import org.springframework.data.repository.CrudRepository
import uk.ac.warwick.example.entities.AuditEvent
import java.util.*

interface AuditEventRepository : CrudRepository<AuditEvent, UUID>
